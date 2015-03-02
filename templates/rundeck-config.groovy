loglevel.default="INFO"
rdeck.base="/var/lib/rundeck"
rss.enabled=false

grails {
  serverURL="{{ rundeck_domain }}"

{% if rundeck_email_address is defined %}
  mail {
    host = "{{ rundeck_smtp_server }}"
    port = 465
    username = "{{ rundeck_email_address }}"
    password = "{{ rundeck_email_password }}"
    props = ["mail.smtp.auth":"true",
             "mail.smtp.socketFactory.port":"465",
             "mail.smtp.socketFactory.class":"javax.net.ssl.SSLSocketFactory",
             "mail.smtp.socketFactory.fallback":"false"]
  }
{% endif %}
}

dataSource {
  dbCreate="update"
  url="jdbc:h2:file:/var/lib/rundeck/data/rundeckdb;MVCC=true"
}