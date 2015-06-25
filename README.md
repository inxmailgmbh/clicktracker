Clicktracker
============

Clicktracker is a small click tracking service. You register your URLs with the service and receive a redirect URL. Whenever the redirect URL is visited the service collects some basic usage metrics and redirects the caller to the original URL.

## Usage

TODO

## Contributing

Install [VirtualBox](https://www.virtualbox.org/) and [Vagrant](https://www.vagrantup.com/).

Now clone this repository and run the following commands:

    $ git clone https://github.com/inxmailgmbh/clicktracker
    $ cd clicktracker
    $ vagrant up
    $ vagrant ssh
    $ cd /vagrant
    $ ./gradlew run

You are now ready to start contributing to this project.
