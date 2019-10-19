#!/bin/bash

METHOD=$1

http POST :8080/$METHOD product=frappuccino name=Luke
http POST :8080/$METHOD product=chai name=Leia
http POST :8080/$METHOD product=hot-chocolate name=Han

