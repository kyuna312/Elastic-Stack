set -euxo pipefail

echo "building jar by maven"
echo ""
mvn clean package -DskipTests

echo "building image with tag of latest"
docker build -t baskanomaly/demo-config .

echo "uploading image tag of latest"
docker push baskanomaly/demo-config