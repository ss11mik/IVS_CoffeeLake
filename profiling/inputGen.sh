#!/bin/bash

rm -f 10 100 1000

for n in {1..10}
do
    echo $((1 + RANDOM % 100000)) >> 10
done

for n in {1..100}
do
    echo $((1 + RANDOM % 100000)) >> 100
done

for n in {1..1000}
do
    echo $((1 + RANDOM % 100000)) >> 1000
done
