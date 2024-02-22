# Base image
FROM openjdk:17

# 애플리케이션을 실행할 디렉토리 생성
WORKDIR /app

# 애플리케이션 JAR 파일 복사
COPY /build/libs/docker-0.0.1-SNAPSHOT.jar /app/my-application.jar

# 애플리케이션 실행 명령 설정
CMD ["java", "-jar", "/app/my-application.jar"]