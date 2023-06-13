import { useRef } from "react"
import { useNavigate } from "react-router-dom"
import axiosInstance from "../api/AxiosConfig"

const Cadastro = () => {

    const navigate = useNavigate()

    const usernameRef = useRef()
    const passwordRef = useRef()

    const realizarCadastro = () => {
        axiosInstance.post("/user/cadastrar", {
            username: usernameRef.current.value,
            password: passwordRef.current.value
        })
        .then((res) => {
            console.log(res)
        })
        .catch(console.log)
    }

    return (
        <>
            <button onClick={() => { navigate("/") }}>retornar à home</button>
            <input ref={usernameRef} type="text" placeholder="username" />
            <input ref={passwordRef} type="text" placeholder="password" />
            <button onClick={realizarCadastro}>Cadastrar</button>
        </>
    )
}

export default Cadastro