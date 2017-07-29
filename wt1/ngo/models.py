from __future__ import unicode_literals
from django.contrib.auth.models import User

from django.db import models




class Profession(models.Model):
	name = models.CharField(max_length=100, blank=True, default=None)
	def __unicode__(self):
		return self.name


class NGO(models.Model):
	Choices = ((0,'Morning'),(1,'Afternoon'),(2,'Evening'),(3,'Anytime'))
	name = models.CharField(max_length=100, blank=True, default=None)
	lat = models.DecimalField(decimal_places=10,max_digits=15,default=None)
	long = models.DecimalField(decimal_places=10,max_digits=15,default=None)
	pref1 = models.IntegerField(choices=Choices,default=None)
	professions = models.ManyToManyField(Profession)
	mail = models.EmailField(blank=True,default=None,null=True)
	about = models.CharField(blank=True,null=True,max_length=200)

	def __unicode__(self):
		return self.name


class Needy(models.Model):
	name = models.CharField(max_length=100, blank=True, default=None)
	phone = models.PositiveIntegerField()
	ngo = models.ForeignKey(NGO)

	def __unicode__(self):
		return self.name






class UserProfile(models.Model):
	user = models.OneToOneField(User)
	age = models.PositiveIntegerField()
	phone_number = models.CharField(max_length=100, blank=True, default=None)

	professions = models.ManyToManyField(Profession)
	Choices = ((0,'Morning'),(1,'Afternoon'),(2,'Evening'))
	pref1 = models.IntegerField(choices=Choices,default=None)
	pref2 = models.IntegerField(choices=Choices,default=None)
	pref3 = models.IntegerField(choices=Choices,default=None)
	lat = models.DecimalField(decimal_places=10,max_digits=15,default=None)
	long = models.DecimalField(decimal_places=10,max_digits=15,default=None)

	def __unicode__(self):
		return self.user.username



