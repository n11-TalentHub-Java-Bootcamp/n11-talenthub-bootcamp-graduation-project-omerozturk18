# pull the base image
FROM node:8.15.0-slim
COPY package.json ./
COPY package-lock.json ./
RUN npm install
COPY . ./
CMD ["npm", "start"]