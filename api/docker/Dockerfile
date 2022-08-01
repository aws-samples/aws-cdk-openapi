FROM ruby:2.6.5-alpine

RUN apk update \
    && apk upgrade --no-cache \
    && apk add --no-cache --repository http://dl-cdn.alpinelinux.org/alpine/v3.14/main/ nodejs=14.20.0-r0 npm \
    && apk add git \
    && apk add --no-cache build-base

# Install node packages and gems
RUN npm install -g widdershins \
    && gem install bundler 

# working directory
WORKDIR /openapi

RUN git clone https://github.com/slatedocs/slate
RUN cd slate \
    && bundle install