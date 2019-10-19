#!/bin/bash

METHOD=$1

http POST :8080/$METHOD product=frappuccino name=Luke
http POST :8080/$METHOD product=chai name=Leia
http POST :8080/$METHOD product=hot-chocolate name=Han
http POST :8080/$METHOD product=latte name=Chewbacca
http POST :8080/$METHOD product=espresso name=Lando
http POST :8080/$METHOD product=mocha name=Vader
http POST :8080/$METHOD product=frappuccino name=Emperor
http POST :8080/$METHOD product=chai name=Rey
http POST :8080/$METHOD product=hot-chocolate name=Finn
http POST :8080/$METHOD product=latte name=Poe

