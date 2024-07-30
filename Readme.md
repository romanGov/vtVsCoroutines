./gradlew clean build
docker build -t romaroman91/virtual:latest .
docker run -p 8080:8080 romaroman91/virtual:latest 

docker push romaroman91/virtual 

minikube start

kubectl run hello-virtual --image=romaroman91/virtual --port=9090 # I don't know how this port can be used

// need define pod name instead of deployment name
kubectl port-forward  virtual-app-8447659c99-s4zn6 -n demo 8080:8080
