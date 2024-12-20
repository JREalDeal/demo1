## Prerequisites:

1. Run Docker Desktop
2. make sure kind is installed: [install kind](https://kind.sigs.k8s.io/docs/user/quick-start/#installing-from-release-binaries)
3. install cloud-provider-kind [install cloud-provider-kind](https://github.com/kubernetes-sigs/cloud-provider-kind/releases)
1. Have the image readily available: moldovean/greetings:latest

## Instructions:

### Create Cluster
run in a new terminal `sudo cloud-provider-kind`, this allows to create services of type LoadBalancer
The sudo is important, otherwise it will not work.

`kind create cluster --name demo` 
`kind delete cluster --name=demo`

### Apply your deployments
`kubectl apply -f greetings-deployment.yaml`

`kubectl apply -f greetings-service.yaml`

### Apply persistent sets
`kubectl get storageclass`
make sure it's `standard` or `default` and  then apply the persistent volume to persisten- volume.yaml

` kubectl get pv `
` kubectl apply -f postgres-pv.yaml `
` kubectl apply -f postgres-pvc.yaml `
` kubectl apply -f postgres-config-map.yaml `
` kubectl apply -f postgres-deployment.yaml `
` kubectl apply -f postgres-service.yaml  `

Check the postgres is running, only if the postgres is running then run this
`kubectl apply -f liqui-deployment.yaml`
Then wait until the pod is in state: COMPLETED


You can then enter inside the pod:
`kubectl exec -it postgres-0 bash`
`psql --username=admin postgresdb`

### Enjoy
`kubectl get all`

### Change the poroject my  liqui manuall with the new postgres IP address
