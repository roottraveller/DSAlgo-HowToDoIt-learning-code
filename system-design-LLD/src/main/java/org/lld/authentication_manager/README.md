Source: https://www.lowleveldesign.io/LLD/Authenticator 

Problem Statement:
There is an authentication system that works with authentication tokens. For each session, the user will receive a new 
authentication token that will expire timeToLive seconds after the currentTime. If the token is renewed, the expiry time
will be extended to expire timeToLive seconds after the (potentially different) currentTime. If a token expires at time 
t, and another action happens on time t (example: request to renew the token or request to get count of unexpired tokens
in the system), the expiration takes place before the other actions. 

Design the system and implement all the core features.