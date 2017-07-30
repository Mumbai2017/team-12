import datetime
from django.db import models


# Create your models here.

class ChildProfile(models.Model):
    id = models.IntegerField(primary_key=True)
    case_no = models.CharField(max_length=10)
    hospital_name = models.CharField(max_length=20)
    name = models.CharField(max_length=20)
    sex = models.CharField(max_length=5)
    date_of_birth = models.DateField()
    age = models.IntegerField()
    mother_tongue = models.CharField(max_length=10)
    father_name = models.CharField(max_length=20)
    mother_name = models.CharField(max_length=20)
    contact_no = models.BigIntegerField()
    disease = models.CharField(max_length=50)
    doctor_id = models.ForeignKey('Doctor')
    vol_id = models.ForeignKey('Volunteer')
    critical = models.BooleanField(default=False)
    wish_type = models.CharField(max_length=20)
    wish1 = models.CharField(max_length=20)
    wish2 = models.CharField(max_length=20)
    wish3 = models.CharField(max_length=20)
    date_submitted = models.DateField()
    approved_wish = models.CharField(max_length=20)
    wish_status = models.IntegerField(default=1)
    donor_id = models.ForeignKey('Donor')
    family = models.TextField(max_length=500)
    friend = models.TextField(max_length=500)
    color = models.TextField(max_length=500)
    book = models.TextField(max_length=500)
    game = models.TextField(max_length=500)
    food = models.TextField(max_length=500)
    music_movie = models.TextField(max_length=500)
    hobby = models.TextField(max_length=500)
    cartoon = models.TextField(max_length=500)
    actor = models.TextField(max_length=500)
    trip = models.TextField(max_length=500)
    ambition = models.TextField(max_length=500)
    bigwish1 = models.TextField(max_length=500)
    bigwish2 = models.TextField(max_length=500)
    bigwish3 = models.TextField(max_length=500)

    def __str__(self):
        return self.name + " - " + self.disease


class Volunteer(models.Model):
    govt_id_no = models.BigIntegerField(primary_key=True)
    name = models.CharField(max_length=20)
    area = models.CharField(max_length=10)
    id_type = models.CharField(max_length=20)
    volunteer_type = models.CharField(max_length=20)
    hospital = models.CharField(max_length=20)
    status = models.BooleanField(default=False)
    points = models.IntegerField()
    contact_no = models.BigIntegerField(default=9870486233)
    email = models.EmailField(default="suhailsbarot@gmail.com")

    def __str__(self):
        return self.name + " - " + self.volunteer_type + " - " + str(self.status)


class Doctor(models.Model):
    doc_id = models.IntegerField(primary_key=True)
    name = models.CharField(max_length=20)
    hospital = models.CharField(max_length=20)
    contact_no = models.BigIntegerField()

    def __str__(self):
        return self.name


class Donor(models.Model):
    donor_id = models.IntegerField(primary_key=True)
    name = models.CharField(max_length=20)
    email = models.EmailField()
    contact_no = models.BigIntegerField()
    points = models.IntegerField()
    amount = models.IntegerField()

    def __str__(self):
        return self.name


class Transaction(models.Model):
    transaction_id = models.BigIntegerField(primary_key=True)
    child_id = models.ForeignKey(ChildProfile)
    amount = models.IntegerField()
    method_of_payment = models.CharField(max_length=50)
    date_of_pay = models.DateField(default=datetime.date.today)


class Staff(models.Model):
    staff_id = models.IntegerField(primary_key=True)
    name = models.CharField(max_length=50)
    contact_no = models.BigIntegerField()
    email = models.EmailField()
    password = models.CharField(max_length=10)
    area = models.CharField(max_length=20)
