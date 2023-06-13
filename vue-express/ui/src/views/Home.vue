<template>
    <div>
        <p>Meu entendimento da integração:</p>
        <p>Socket.io é uma tecnologia que faz uma ponte entre o back-end e os clientes. O socket permite que as aplicações front e back se comuniquem por meio das funções "emit" e "on", que:</p>
        <p>Quando é executada a função "emit" pelo back-end, ele emite uma mensagem à TODOS os clientes conectados e ouvindo um determinado "endpoint"</p>
        <p>Quando é executada a função "emit" pelo front-end, ele emite uma mensagem ao sevidor back-end, que recebe caso esteja ouvindo o "endpoint" específico.</p>
        <p>As funções "on" servem para especificar quais "endpoints" serão observados, tanto pelo front quando pelo back</p>
        <p>Os "endpoints" citados são apenas strings como nomes de endpoint, por ex: "socket.emit("MESSAGE")" ativa todas as aplicações que contém o comando "socket.on("MESSAGE")"</p>
        <ul>
            <li v-for="(mensagem, i) in mensagens" :key=i>{{ mensagem.conteudo }}</li>
        </ul>
        <input type="text" v-model="fieldMensagem" @keydown.enter="mandarMsg"><br>
    </div>
</template>

<script>
import io from "socket.io-client"

export default {
    name: "Home",
    data() {
        return {
            mensagens: [
                {
                    autor: "usuario",
                    conteudo: "mensagem"
                }
            ],
            fieldMensagem: "",
            socket: io("http://localhost:3001")
        }
    },
    methods: {
        mandarMsg() {
            this.socket.emit("SEND_MESSAGE", {
                user: "usuario",
                message: this.fieldMensagem
            })
            this.fieldMensagem = ""
        }
    },
    mounted() {
        this.socket.on("MESSAGE", data => {
            this.mensagens.push({
                autor: data.user,
                conteudo: data.message
            })
        })
    }
}
</script>