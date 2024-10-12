FROM node:18-alpine

WORKDIR /app

# package.json AND package-lock.json をコピー
COPY package*.json ./

# 開発依存関係を含めてインストール
RUN npm install

# アプリケーションのソースをコピー
COPY . .

# 開発モードでアプリケーションを起動
CMD ["npm", "run", "dev"]
