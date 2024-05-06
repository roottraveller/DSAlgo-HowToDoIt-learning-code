Source: https://www.lowleveldesign.io/LLD/FileSharingSystem 

Problem Statement:
You are working on building a file sharing system to share a very large file which consists of m small chunks with IDs from 1 to m.

When users join the system, the system should assign a unique ID to them. The unique ID should be used once for each user, but when a user leaves the system, the ID can be reused again. The unique ID starts from 1.

Users can request a certain chunk of the file, the system should return a list of IDs of all the users who own this chunk. If the user receives a non-empty list of IDs, they receive the requested chunk successfully.

How would you design and implement the file sharing system ?