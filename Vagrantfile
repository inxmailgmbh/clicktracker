# -*- mode: ruby -*-
# vi: set ft=ruby :

Vagrant.configure(2) do |config|
  config.vm.define "clicktracker", primary: true do |dev|
    dev.vm.box = "clicktracker"
    dev.vm.box_url = "http://build.srv.inxmail.de/resources/vagrant/boxes/debian-jessie-64.box"

    dev.vm.provision "shell", path: "provisioning/basic.sh"
    dev.vm.provision "shell", path: "provisioning/postgres_dev_config.sh"
    dev.vm.network "private_network", ip: "192.168.81.11"
    dev.vm.provider :virtualbox do |vb|
      vb.memory = 1024
    end
  end

  config.vm.define "clicktracker_docker", autostart: false do |docker|
    # docker.vm.box = "clicktracker_on_docker"
    # docker.vm.provision "docker" do |d|
    #   # ...
    # end
    #
    # NOTE: This is a possible starting point to build up a docker container for
    # this project I have no experience with the vagrant docker provisioner and
    # don't know if this is a suitable way forward. Please investigate on your own
    # and decide accordingly.
    #
    # This vagrant box will not be started automatically with `vagrant up`. You can
    # fire up this box with the following command:
    # `vagrant up clicktracker_docker`
  end
end
