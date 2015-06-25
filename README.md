Clicktracker
============

Clicktracker is a small click tracking service. You register your URLs with the service and receive a redirect URL. Whenever the redirect URL is visited the service collects some basic usage metrics and redirects the caller to the original URL.

## Usage [WIP]

Create a new tracked URL by sending a POST request to http://localhost:8989/api/url with the URL you want to track as input.

```
$ curl -X POST http://localhost:8989/api/url \
  -H 'Content-Type: application/json' \
  -d '{"longURL": "https://url.to.something/"}'

HTTP/1.1 201 Created
Location: http://localhost:8989/<random-short-code>
```

Clicktracker will garantee to always create a new tracked URL. This enables to track the same target URL multiple times.

Opening the URL will redirect you to the original URL.

```
$ curl -i http://localhost:8989/<random-short-code>

HTTP/1.1 302 Found
Location: https://url.to.something/
```

Every call on the tracked URL will track some basic user information (time of call, number of total clicks, etc).

You can request the gathers click data on a tracked URL by sending the following GET request:

```
$ curl http://localhost:8989/api/url?slug=<random-short-code>

{
  "id": 1,
  "slug": "<random-short-code>",
  "longURL": "https://url.to.something/",
  "createdAt": "2015-06-15T10:12:23.000+00:00",
  "clickData": {
    // ...
  }
}
```

## Streaming [WIP]

It will be possible to register URLs with a specific Organization. We will stream an (almost) real-time traffic feed of click events back to the Organization. Details for this mechanism are currently undefined.

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
