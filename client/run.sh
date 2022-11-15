#!/bin/bash

export PATH="/usr/lib/jvm/java-8-openjdk/bin/:$PATH"

PROJECT="client"

if tmux has-session -t $PROJECT; then
    tmux kill-session -t $PROJECT
fi

tmux new-session -d -s $PROJECT
tmux send-keys -t $PROJECT "java -Dsbt.global.base=$XDG_DATA_HOME/sbt -Dsbt.ivy.home=$XDG_CACHE_HOME/ivy2/ -Divy.home=$XDG_CACHE_HOME/ivy2/ -Dfile.encoding=UTF8 -Djline.terminal=none -Dsbt.global.base=/tmp/sbt-global-plugin1stub -Dsbt.log.noformat=true -Xms512M -Xmx1024M -Xss1M -XX:+CMSClassUnloadingEnabled -Didea.managed=true -classpath /usr/share/sbt/bin/sbt-launch.jar xsbt.boot.Boot \"project client\" \"run 9038\"" Enter
