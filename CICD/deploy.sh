#!/bin/bash

JARFILE=/opt/microgreen.jar

systemctl stop microgreen.service

if ! [ -f $JARFILE ]; then
  rm -f JARFILE
fi

cp ./target/microgreen.jar /opt/

systemctl start microgreen.service