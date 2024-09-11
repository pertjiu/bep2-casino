# HUland Casino Project
This project is part of an assignment for the
course Backend Programming 2 (BEP2) at the
Hogeschool Utrecht, University of Applied Sciences.

## Starter project
This starter project contains the following:

* A Maven-based setup with several 
third-party libraries and frameworks (see: `pom.xml`)
* A component for basic 
chip functionality (`nl.hu.bep2.casino.chips`)

## Prerequisites
Although it is recommended to always use the latest stable version
of Java, this project requires a version of Java 21 or higher.
You can customize this in your compilation settings and `pom.xml`.

For [Maven](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html),
you can use your IDE, install it [globally](https://maven.apache.org/download.cgi), 
or use the supplied `mvnw` or `mvnw.cmd`.


## Booting
First, make sure the database is set up, started and reachable.

Start the application via your IDE by running the `CasinoApplication`
class.


## Component overview
One component, *chips*, has already been created.
Students will have to make a new component, *blackjack*.
Keep in mind that the blackjack component will start with
an object-oriented domain layer. 
Other layers will be added as development (and learning) progresses.

It is a good idea to create a package structure that reflects
the application architecture.
