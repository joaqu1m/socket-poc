import { useEffect, useRef, useState } from "react"
import { useLocation, useNavigate } from "react-router-dom"
import styles from "./Chat.module.css"
import axiosInstance from "../api/AxiosConfig"
import io from 'socket.io-client'

const Chat = () => {

    const navigate = useNavigate()
    const location = useLocation()

    const [idUser, setIdUser] = useState()
    const [data, setData] = useState([])

    const mensagemRef = useRef()

    useEffect(() => {
        if (location.state) {
            setIdUser(location.state.id)
        } else {
            navigate("/")
        }
        
        socket.on('message', newMessage => {
            setData(prevData => [...prevData, newMessage])
        })

        fetchData()

        return () => {
            socket.off('message')
        }
    }, [])

    const fetchData = () => {
        axiosInstance.get('/chat')
            .then(response => {
                setData(response.data)
            })
            .catch(console.log)
    }

    const createData = () => {
        axiosInstance.post('/chat', {
            from: idUser,
            msg: mensagemRef.current.value,
            sentAt: new Date()
        })
            .then(console.log)
            .catch(console.log)
    }

    return (
        <>
            <button onClick={() => { navigate("/") }}>logoff</button>
            <div className={styles["chat"]}>
                <input ref={mensagemRef} type="text" placeholder="mensagem" />
                <button onClick={fetchData}>enviarMensagem</button>
                <button onClick={createData}>pegarMensagem</button>
            </div>
        </>
    )
}

export default Chat