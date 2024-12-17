#!/usr/bin/env bash
echo "Hello from helper.sh"
echo "Applying Postgres to k8s"
echo "Applying persistent volume"
kubectl apply -f persistent-volume.yaml
echo "Applying persistent volume claim"
kubectl apply -f postgres-pvc.yaml
echo "Applying postgres configmap"
kubectl apply -f postgres-config-map.yaml
kubectl get configmaps
echo "Applying postgres deployment"
kubectl apply -f postgres-deployment.yaml
echo "Applying postgres service"
kubectl apply -f postgres-service.yaml
