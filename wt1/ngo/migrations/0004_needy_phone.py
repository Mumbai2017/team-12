# -*- coding: utf-8 -*-
# Generated by Django 1.10.2 on 2016-11-04 15:23
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('ngo', '0003_remove_userprofile_address'),
    ]

    operations = [
        migrations.AddField(
            model_name='needy',
            name='phone',
            field=models.PositiveIntegerField(default=12345),
            preserve_default=False,
        ),
    ]
