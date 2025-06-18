FROM ubuntu:22.04
# Variables de entorno para SDKMAN
ENV SDKMAN_DIR="/root/.sdkman"
ENV JAVA_VERSION="23.0.2-graalce"
ENV DEBIAN_FRONTEND=noninteractive

# Instalación de dependencias necesarias
RUN apt-get update && \
    apt-get install -y apt-utils curl unzip zip build-essential libstdc++6 wget git && \
    rm -rf /var/lib/apt/lists/*

# Instalación de SDKMAN
RUN curl -s "https://get.sdkman.io" | bash

# Inicializamos SDKMAN en el entorno
RUN bash -c "source /root/.sdkman/bin/sdkman-init.sh && sdk install java ${JAVA_VERSION} && java -version"

# Exportamos variables para que queden permanentes
RUN echo "source /root/.sdkman/bin/sdkman-init.sh" >> /root/.bashrc

# Instala Docker dentro del contenedor (si deseas que el contenedor pueda construir imágenes)
RUN apt-get update && \
    apt-get install -y docker.io && \
    rm -rf /var/lib/apt/lists/*

# Creamos la carpeta donde estará tu proyecto
WORKDIR /home/builder/project

# ¡Listo para usar bash directamente!
CMD [ "/bin/bash" ] 