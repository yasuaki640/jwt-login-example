import axios from "axios";

const endPoint = process.env.REACT_APP_SERVER_ENDPOINT;

export const auth = (userId, password) => {
    return axios.post(endPoint + '/auth', {
        userId: userId,
        password: password
    });

};

