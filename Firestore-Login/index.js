const express = require('express');
const Firestore = require('@google-cloud/firestore')
const db = new Firestore();
const app = express();
app.use(express.json());
const port = process.env.PORT || 8080;
app.listen(port, () => {
    console.log(`Firestore Rest API berjalan pada port ${port}`);
});

app.get('/', async (req, res) => {
    res.json({
        status: 'Layanan berhasil dijalankan.'
    });
})

app.get('/:login', async (req, res) => {
    const login = req.params.login;
    const query = db.collection('users').where('username', '==', login);
    const querySnapshot = await query.get();
    if (querySnapshot.size > 0) {
        res.json(querySnapshot.docs[0].data());
    } else {
        res.json({
            status: 'Tidak Ditemukan'
        });
    }
})

app.post('/', async (req, res) => {
    const data = {
        username: req.body.username,
        password: req.body.password
    }
    await db.collection('users').doc().set(data);
    res.json({
        status: 'success',
        data: {
            user: data
        }
    });
})