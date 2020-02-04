// main.js

import Vue from 'vue'
import App from './App.vue'
import 'bootstrap/dist/css/bootstrap.min.css'
import "quasar-framework/dist/umd/quasar.mat.css";

Vue.use(Quasar);

import VueRouter from 'vue-router';
Vue.use(VueRouter);

Vue.config.productionTip = false;

import HomeContact from './components/HomeContact.vue';
import CreateContact from './components/CreateContact.vue';
import IndexContact from './components/IndexContact.vue';
import EditContact from './components/EditContact.vue';

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
      name: 'edit',
      path: '/edit/:id',
      contact: EditContact
  }
];

const router = new VueRouter({ mode: 'history', routes: routes});

new Vue(Vue.util.extend({ router }, App)).$mount('#app');