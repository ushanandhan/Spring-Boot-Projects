![image](https://user-images.githubusercontent.com/8769673/134659883-da20ee62-e053-45fc-a723-487f09581991.png)

# Deploying Spring Boot Application With Docker and Minikube on Windows

## 1. Prerequisites:
1) Spring Boot Application
2) Docker should be installed.
3) Minikube should be installed.

## 1. Spring Boot Application:
Here we have simple application with one controller. Nothing much to discuss.

## 2. Create Dockerfile in  below path.
![image](https://user-images.githubusercontent.com/8769673/134660602-d33daffb-4584-4ced-a44e-70a10c692fa9.png)

```Dockerfile
FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/SpringBoot-Docker-Kubernates-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
```
Before build Dockerfile check whether minikube is started?
type command ```minikube status ```
you will get the status as below,
![image](https://user-images.githubusercontent.com/8769673/134661341-b577ea42-3693-45a5-ae77-6e8b8001cdc8.png)

Here it is running. If not you can run the command ``` minikube start ```.

Normally docker images will not be available for minikube. So run ```minikube docker-env```. This will give below command.
![image](https://user-images.githubusercontent.com/8769673/134661870-54683154-00aa-45c9-9807-dce59df01a3c.png)

Run 
``` @FOR /f "tokens=*" %i IN ('minikube -p minikube docker-env') DO @%i``` in command prompt. Now if you run ```docker images``` we can get images for minikube. So

Now to build this application type following command. 
````docker build -t springboot-k8s:2.0 . ````
Now our application image is available in the docker images as below,

![image](https://user-images.githubusercontent.com/8769673/134662595-3d08179d-fc31-4f22-8417-25ea595a68f2.png)

## 3. Create deployment and service yaml file for Kubernetes
* Create Deployment yaml file:
```yaml
apiVersion: apps/v1
kind: Deployment
metadata:
  name: springboot-k8s-deploy
spec:
  selector:
    matchLabels:
      app: springboot-k8s
  replicas: 3
  template:
    metadata:
      labels:
        app: springboot-k8s
    spec:
      containers:
        - name: springboot-k8s
          image: springboot-k8s:2.0
          ports:
            - containerPort: 6060
```
* Create Service yaml file:
```yaml
apiVersion: v1
kind: Service
metadata:
  name: springboot-k8s-service
  labels:
    name: springboot-k8s
spec:
  ports:
    - nodePort: 31875
      port: 6060
      targetPort: 6060
      protocol: TCP
  selector:
    app: springboot-k8s
  type: NodePort
```
* Run Both Service and Deployment file one by one with below command:
```script
kubectl apply -f deployment.yml
kubectl apply -f service.yml
```
* Now if you run below command:
```script
kubectl get all
```
![image](https://user-images.githubusercontent.com/8769673/134665455-18c32e82-24fe-4e1f-8b66-34510d933948.png)

We can see all pods, services and deployments here.

* Run below command to get the url of minikube to access the services.
```script
minikube service springboot-k8s-service --url
```
Now we can get the url to access minikube as per below screenshot.
![image](https://user-images.githubusercontent.com/8769673/134665966-d6cbc86b-f25a-448c-8801-f4244a2a5ffe.png)

![image](https://user-images.githubusercontent.com/8769673/134666081-ba1b9d84-52c9-466d-980a-71897b94ce8d.png)

That's all about deployment of spring boot application with Docker and kubernetes (minikube). 
We'll catch up with other topics in future. 