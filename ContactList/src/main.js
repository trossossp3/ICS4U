// main.js

import Vue from 'vue'
import App from './App.vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import './quasar'



import VueRouter from 'vue-router';
Vue.use(VueRouter);
import VueAxios from 'vue-axios';
import axios from 'axios';

Vue.use(VueAxios, axios);

Vue.config.productionTip = false;
Vue.config.productionTip = false;

import HomeContact from './components/HomeContact.vue';
import CreateContact from './components/CreateContact.vue';
import IndexContact from './components/IndexContact.vue';
import EditContact from './components/EditContact.vue';
//import ListContacts from './components/ListContacts.vue'; 
import './quasar'
import Buefy from 'buefy';
import 'buefy/dist/buefy.css';

Vue.use(Buefy);

const routes = [
  {
      name: 'home',
      path: '/',
      component: HomeContact
  },
  {
      name: 'create',
      path: '/create',
      component: CreateContact
  },
  {
      name: 'posts',
      path: '/posts',
      component: IndexContact
  },
  {
      name: 'list',
      path: '/list',
      component: IndexContact
      
  },
  {
    name: 'edit',
    path: '/edit/:id',
    component: EditContact
}
];

const router = new VueRouter({ mode: 'history', routes: routes});

new Vue(Vue.util.extend({ router }, App)).$mount('#app');