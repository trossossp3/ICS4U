//CreateComponenet.vue
<template>
  <div>
    <h1 style="font-size:100px;">Create A Contact</h1>
    <br>
    <form @submit.prevent="addPost">
      <div class="row">
        <div class="col-md-6">


          <b-field label="First Name">
            <b-input v-model="post.fName" placeholder="Kevin"></b-input>
          </b-field>
          <b-field label="Last Name">
            <b-input v-model="post.lName" placeholder="DesLaurier"></b-input>
          </b-field>
          <b-field label="Adress">
            <b-input v-model="post.address" placeholder="85 Moatfielf"></b-input>
          </b-field>
          <b-field label="Email">
            <b-input type="email" v-model="post.email" placeholder="jaysfan1@futurebluejay.org">
            </b-input>
          </b-field>
          <b-field label="Phone Number">
            <b-input type="number" v-model="post.phone" placeholder="2"></b-input>
          </b-field>
        </div>
      </div>
      <br>

      <div class="form-group">
        <button class="btn btn-primary">Create</button>
      </div>
    </form>
  </div>
</template>


<script>
  export default {
    data() {
      return {
        post: {}
      }
    },
    methods: {
      addPost() {

        let uri = 'http://localhost:4000/posts/add';
        this.axios.post(uri, this.post).then(() => {
          this.$router.push({ name: 'posts' });
        });
      }
    }

  }

</script>