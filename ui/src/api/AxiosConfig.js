import axios from "axios"

const axiosInstance = axios.create({
    baseURL: "http://localhost:8080",
    headers: {
        timeout: 10000,
        "Content-type": "application/json"
    }
})

export default axiosInstance