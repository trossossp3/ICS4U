// main.js

import Vue from 'vue'
import App from './App.vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import './quasar'



import VueRouter from 'vue-router';
Vue.use(VueRouter);

Vue.config.productionTip = false;

import HomeContact from './components/HomeContact.vue';
import CreateContact from './components/CreateContact.vue';
import IndexContact from './components/IndexContact.vue';
import EditContact from './components/EditContact.vue';
import ListContacts from './components/ListContacts.vue'; 
import './quasar'

const routes = [
  {
      name: 'home',
      path: '/',
      contact: HomeContact
  },
  {
      name: 'create',
      path: '/create',
      contact: CreateContact
  },
  {
      name: 'posts',
      path: '/posts',
      contact: IndexContact
  },
  {
      name: 'list',
      path: '/list',
      contact: ListContacts
  },
  {
    name: 'edit',
    path: '/edit/:id',
    contact: EditContact
}
];

const router = new VueRouter({ mode: 'history', routes: routes});

new Vue(Vue.util.extend({ router }, App)).$mount('#app');