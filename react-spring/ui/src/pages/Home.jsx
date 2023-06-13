import { useNavigate } from "react-router-dom"
import styles from "./Home.module.css"

const Home = () => {

    const navigate = useNavigate()

    return (
        <>
            <h1 className={styles["titulo"]}>Home</h1>
            <button onClick={() => { navigate("/login") }}>Ir para login</button>
            <button onClick={() => { navigate("/cadastro") }}>Ir para cadastro</button>
        </>
    )
}

export default Home