<template>
  <div>
      <h1>Contacts</h1>
        
        <table class="table table-hover">
            <thead>
            <tr>
              <th>First Name</th>
              <th>Last Name</th>
              <th>Phone Number</th>
              <th>Adress</th>
              <th>Email</th>
            </tr>
            </thead>
            <tbody>
                <tr v-for="post in posts" :key="post._id">
                  <td>{{ post.fName }}</td>
                  <td>{{ post.lName }}</td>
                  <td>{{ post.number }}</td>
                  <td>{{ post.address }}</td>
                  <td>{{ post.email }}</td>
                  <td><router-link :to="{name: 'edit', params: { id: post._id }}" class="btn btn-primary">Edit</router-link></td>
                  <td><button class="btn btn-danger" @click.prevent="deletePost(post._id)">Delete</button></td>
                </tr>
            </tbody>
        </table>
  </div>
</template>