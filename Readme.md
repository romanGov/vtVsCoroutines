./gradlew clean build
docker build -t romaroman91/virtual:latest .
docker run -p 8080:8080 romaroman91/virtual:latest 

docker push romaroman91/virtual 

minikube start

kubectl run hello-virtual --image=romaroman91/virtual --port=9090 # I don't know how this port can be used

minikube dashboard (launch minikube dashboard)

// need define pod name instead of deployment name
kubectl port-forward    virtual-app-758bf9b674-ksjzd    -n demo 8080:8080

kubectl apply -f {path_to_file}
