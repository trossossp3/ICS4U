// EditComponent.vue

<template>
  <div>
    <h1 style="font-size:100px;">Edit Contact</h1>
    <form @submit.prevent="updatePost">
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
          <button class="btn btn-primary">Update</button>
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
      created() {
        let uri = `http://localhost:4000/posts/edit/${this.$route.params.id}`;
        this.axios.get(uri).then((response) => {
            this.post = response.data;
        });
      },
      methods: {
        updatePost() {
          let uri = `http://localhost:4000/posts/update/${this.$route.params.id}`;
          this.axios.post(uri, this.post).then(() => {
            this.$router.push({name: 'posts'});
          });
        }
      }
    }
</script>