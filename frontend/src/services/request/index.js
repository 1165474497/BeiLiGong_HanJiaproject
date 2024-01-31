import axios from 'axios';
import {BASE_URL, TIMEOUT} from '../request/config.js';


class HYRequest {
    constructor(baseURL, timeout = 10000) {
        this.instance = axios.create({
            baseURL,
            timeout,
        });

        this.instance.interceptors.request.use(
            config => {
                // 当前路由不是登录页时，添加token
                return config;
            },
            err => {
                return Promise.reject(err)
            }
        );

        this.instance.interceptors.response.use(
            res => {
                return res;
            },
            err => {
                // 401 "token过期" 处理
                // if (err.response?.status === 500) {
                //     myNotification('服务器错误', 'error')
                // }
                // const msg = err.response.data || '请求失败';
                return Promise.reject(err)
            }
        );
    }

    request(config) {
        return new Promise((resolve, reject) => {
            this.instance
                .request(config)
                .then(res => {
                    resolve(res.data);
                })
                .catch(err => {
                    reject(err);
                });
        });
    }

    get(config) {
        return this.request({...config, method: 'get'});
    }

    post(config) {
        return this.request({...config, method: 'post'});
    }
}

export default new HYRequest(BASE_URL, TIMEOUT);
