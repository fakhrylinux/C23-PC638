GOOGLE_PROJECT_ID=c23-pc638

gcloud builds submit --tag gcr.io/$GOOGLE_PROJECT_ID/c23-pc638api \
  --project=$GOOGLE_PROJECT_ID

gcloud beta run deploy c23-pc638-api \
  --image gcr.io/$GOOGLE_PROJECT_ID/c23-pc638api \
  --platform managed \
  --region asia-southeast2 \
  --project=$GOOGLE_PROJECT_ID