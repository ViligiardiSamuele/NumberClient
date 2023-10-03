# Connessione 
|Porta| Tipo |
|-|-|
|3000|TCP|

# Protocollo
| Codice  | Direzione | Funzione  |
|-|-|-|
| 0 | Ricevuto | Client ha indovinato |
| 1 | Ricevuto | Client ha inviato un numero più grande |
| -1 | Ricevuto | Client ha inviato un numero più piccolo |
| -1 | Inviato | Client ha richiesto la chiusura del server ed attende |
| -2 | Ricevuto | Server ha ricevuto il comando di chisura e comunica al client che può chiudersi anche lui |