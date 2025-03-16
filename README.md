Spring AI ETL pipeline for embedding the (2025) DevNexus catalog and then querying same.  Each conference
session is a document and includes the following:
* id
* title
* description
* room
* speakers
* startsAt
* endsAt

This app uses spring-boot-docker-compose.  Docker images for pgvector and ollama are used.

This app will download the catalog file, ingest it, and then query the top 5 documents to match whatever query
string the use enters.

Hit 'Enter' twice to exit.
