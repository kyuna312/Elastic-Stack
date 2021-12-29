set -euxo pipefail

echo "building jar by maven"
echo ""
mvn clean package -DskipTests

echo "building image with tag of latest"
docker build -t baskanomaly/demo-app .