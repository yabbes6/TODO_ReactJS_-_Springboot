import axios from "axios"

export default axios.create({
    baseURL : "http://localhost:8085/api/v1/plans"
})