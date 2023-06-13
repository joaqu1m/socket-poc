const express = require("express")
const app = express()

const httpServer = app.listen(3001)

const io = require("socket.io")(httpServer, {
    cors: {
        origin: "http://localhost:3000",
        methods: ["GET", "POST", "PUT", "PATCH", "DELETE"]
    }
})

io.on("connection", (socket) => {
    console.log(socket.id)
    socket.on("SEND_MESSAGE", (data) => {
        io.emit("MESSAGE", data)
    })
})