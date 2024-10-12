FROM openjdk:17.0.2-jdk-slim AS build
WORKDIR /app

# Mavenをインストール
RUN apt-get update && \
    apt-get install -y --no-install-recommends maven && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# プロジェクトファイルをコピー
COPY src/backend/myapp/pom.xml .
COPY src/backend/myapp/src ./src

# 依存関係のダウンロードとビルド
RUN mvn package spring-boot:repackage -DskipTests

# テストをパスする場合
# RUN --mount=type=cache,target=/root/.m2 mvn package -Dmaven.test.skip=true

# アプリケーションの実行
FROM openjdk:17.0.2-jdk-slim
WORKDIR /app

RUN apt-get update && \
    apt-get install -y --no-install-recommends maven && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*


# ビルドしたjarをコピー（名前を指定）
COPY --from=build /app/target/app.jar app.jar

# ログファイルをコピー（オプション）
# COPY --from=build /app/mvn_build_log.txt ./
# ログファイルをコピー
# COPY --from=build /app/*.txt .

# 実行権限を付与
RUN chmod +x app.jar

# コンテナ起動時にspring-boot:runを実行するスクリプトを追加
COPY docker/java/entrypoint.sh /entrypoint.sh
RUN chmod +x /entrypoint.sh

ENTRYPOINT ["/entrypoint.sh"]
