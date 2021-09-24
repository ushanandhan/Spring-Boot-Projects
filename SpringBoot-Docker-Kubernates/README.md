![image](https://user-images.githubusercontent.com/8769673/134659883-da20ee62-e053-45fc-a723-487f09581991.png)

# Deploying Spring Boot Application With Docker and Minikube on Windows

## 1. Prerequisites:
1) Spring Boot Application
2) Docker should be installed.
3) Minikube should be installed.

## Spring Boot Application:
Here we have simple application with one controller. Nothing much to discuss.

## Create Dockerfile in  below path.
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
