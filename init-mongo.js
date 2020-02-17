db.createUser(
    {
        user: "demo",
        pwd: "password",
        roles: [
            {
                role: "readWrite",
                db: "test"
            }
        ]
    }
);

db.createCollection("test");
