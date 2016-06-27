##Dependency Injection with Spring

Simple PoC of dependency injection using Spring Framework.

Dependency injection is essential for decoupling code. It makes software easier
to maintain, easier to grow and easier to test.

This PoC is an Agenda that uses an injected contact service in order to
maintain a list of contacts. The contact service uses an injected DAO
in order to talk to the database (represented by a In-Memory Map of contacts.

