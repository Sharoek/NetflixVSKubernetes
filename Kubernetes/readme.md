# Kubernetes

## Minikube
Follow these steps how to install [minikube](https://minikube.sigs.k8s.io/docs/start/?arch=%2Fwindows%2Fx86-64%2Fstable%2F.exe+download)

After setting that up apply the deployment and services 
```yaml
kubectl apply -f *name of the service or deployment* 
```

After that here are some handy commands

```yml

kubectl get deployments
kubectl get services
kubectl get rs 
kubectl get pods --show-labels
kubectl rollout status deployment/nginx-deployment
kubectl describe svc *service name*
```


After all is setup and working to test create a temporary pod by running the follow command
```yml
kubectl run curlpod --image=curlimages/curl -it --rm -- /bin/sh
```

Try to curl the different services 
```yml
 curl nginx-service
 curl http://hello-minikube:8080
```
