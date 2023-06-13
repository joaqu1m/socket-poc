import { useRef } from "react"
import axiosInstance from "../api/AxiosConfig"
import { useNavigate } from "react-router-dom"

const Login = () => {

    const navigate = useNavigate()

    const usernameRef = useRef()
    const passwordRef = useRef()

    const realizarLogin = () => {
        axiosInstance.post("/user/login", {
            username: usernameRef.current.value,
            password: passwordRef.current.value
        })
        .then((res) => {
            if (res.status === 200) {
                navigate("/chat", { state: {id: res.data} })
            } else {
                console.log(res)
            }
        })
        .catch((err) => {
            if (err.response.status === 403 || err.response.state === 404) {
                alert("Usuário ou senha incorretos")
            } else {
                console.log(err)
            }
        })
    }

    return (
        <>
            <button onClick={() => { navigate("/") }}>retornar à home</button>
            <input ref={usernameRef} type="text" placeholder="username" />
            <input ref={passwordRef} type="text" placeholder="password" />
            <button onClick={realizarLogin}>login</button>
        </>
    )
}

export default Login