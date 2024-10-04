# Introduction

The realtime layer provides recipes and configuration required to run linux kernel as a real time kernel on raspberrypi 4/5. This layer supports two recipes, one is related to preempt_rt, the other is xenomai4. Both recipes are fetches and builds linux kernel.

### How to build realtime kernel

We recommends the kas to setup and build realtime kernel on raspberrypi.

#### Setup build environment

```sh
$ mkdir rpi5-test
$ cd rpi5-test
$ git clone https://github.com/geek43/raspberrypi
```

### Build preempt-rt kernel
```sh
$ kas build rpi5-preempt-rt
```

### Build xenomai4 kernel
```sh
$ kas build rpi5-xenomai4
```

### flash
