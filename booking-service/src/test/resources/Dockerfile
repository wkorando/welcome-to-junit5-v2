FROM postgres:9.6.12

COPY 1_schema.sql /docker-entrypoint-initdb.d/
COPY 2_data.sql /docker-entrypoint-initdb.d/

COPY docker-entrypoint.sh /usr/local/bin/
RUN chmod +x /usr/local/bin/docker-entrypoint.sh
ENTRYPOINT ["docker-entrypoint.sh"]